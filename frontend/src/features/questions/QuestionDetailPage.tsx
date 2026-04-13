import { useQuery } from '@tanstack/react-query';
import { useParams } from 'react-router-dom';
import { api } from '../../lib/api';

export function QuestionDetailPage() {
  const { id } = useParams();
  const { data, isLoading } = useQuery({ queryKey: ['question', id], queryFn: async () => (await api.get(`/questions/${id}`)).data });
  if (isLoading) return <div className="card">Loading question...</div>;
  return <article className="card"><h2 className="text-xl">{data?.title}</h2><p className="mt-2 text-slate-300">{data?.body}</p></article>;
}
