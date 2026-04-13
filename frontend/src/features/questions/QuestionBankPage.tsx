import { useQuery } from '@tanstack/react-query';
import { Link } from 'react-router-dom';
import { api } from '../../lib/api';

export function QuestionBankPage() {
  const { data, isLoading, isError } = useQuery({ queryKey: ['questions'], queryFn: async () => (await api.get('/questions')).data });
  if (isLoading) return <div className="card">Loading question bank...</div>;
  if (isError) return <div className="card">Failed to load questions.</div>;
  return <div className="space-y-3">{(data ?? []).map((q: any) => <Link key={q.id} to={`/questions/${q.id}`} className="card block"><h3>{q.title}</h3><p className="text-xs text-slate-400">{q.questionType} • {q.difficulty}</p></Link>)}</div>;
}
