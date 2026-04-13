import { useState } from 'react';
import { api } from '../../lib/api';

export function MockInterviewFlowPage() {
  const [result, setResult] = useState<any>(null);
  const start = async () => {
    const res = await api.post('/interviews/sessions', {
      userId: 1, technologyIds: [1, 12], experienceYears: 5, targetDifficulty: 'INTERMEDIATE',
      questionCount: 10, questionTypes: ['THEORY','CODING','SCENARIO','ARCHITECTURE','DEBUGGING','BEHAVIORAL'],
      excludeSkippedQuestions: true, recycleOnExhaustion: false
    });
    setResult(res.data);
  };
  return <section className="space-y-3"><button onClick={start} className="rounded bg-cyan-500 px-4 py-2 text-slate-900">Start Mock Interview</button>{result && <pre className="card overflow-auto text-xs">{JSON.stringify(result, null, 2)}</pre>}</section>;
}
