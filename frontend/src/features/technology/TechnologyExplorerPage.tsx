import { useQuery } from '@tanstack/react-query';
import { api } from '../../lib/api';

export function TechnologyExplorerPage() {
  const { data, isLoading } = useQuery({ queryKey: ['technologies'], queryFn: async () => (await api.get('/technologies')).data });
  if (isLoading) return <div className="card">Loading technologies...</div>;
  return <div className="grid gap-3 md:grid-cols-3">{(data ?? []).map((t: any) => <div key={t.id} className="card"><h3 className="font-medium">{t.name}</h3><p className="text-xs text-violet-300">{t.category}</p></div>)}</div>;
}
